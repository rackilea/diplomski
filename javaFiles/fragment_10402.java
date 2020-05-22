package com;

public enum Ingredient {

 CHEESE, TOMATO, LETTUCE, BACON, BREAD, MEATBALL, ITALIAN_SAUCE;

 private final String description;

 Ingredient() {
  description = toString().toLowerCase();
 }

 Ingredient(String description) {
  this.description = description;
 }

 public String getDescription() {
  return description;
 }
}


package com;

import static com.Ingredient.*;

import java.util.*;
import static java.util.Arrays.asList;

public enum SandwitchType {

 BLT(
   asList(TOMATO, LETTUCE, BACON, BREAD),
             1  ,    1,      1  ,   1
 ),
 SUB(
   asList(MEATBALL, CHEESE, ITALIAN_SAUCE, BREAD),
              1   ,    1  ,      1       ,   1
 );

 private final Map<Ingredient, Integer> ingredients = new EnumMap<Ingredient, Integer>(Ingredient.class);
 private final Map<Ingredient, Integer> ingredientsView = Collections.unmodifiableMap(ingredients);

 SandwitchType(Collection<Ingredient> ingredients, int ... unitsNumber) {
  int i = -1;
  for (Ingredient ingredient : ingredients) {
   if (++i >= unitsNumber.length) {
    throw new IllegalArgumentException(String.format("Can't create sandwitch %s. Reason: given ingedients "
      + "and their units number are inconsistent (%d ingredients, %d units number)", 
      this, ingredients.size(), unitsNumber.length));
   }
   this.ingredients.put(ingredient, unitsNumber[i]);
  }
 }

 public Map<Ingredient, Integer> getIngredients() {
  return ingredientsView;
 }

 public String getDescription() {
  StringBuilder result = new StringBuilder();
  for (Ingredient ingredient : ingredients.keySet()) {
   result.append(ingredient.getDescription()).append(", ");
  }

  if (result.length() > 1) {
   result.setLength(result.length() - 2);
  }
  return result.toString();
 }
}


package com;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class PriceList {

 private static final int PRECISION = 2;

 private final ConcurrentMap<Ingredient, Double> prices = new ConcurrentHashMap<Ingredient, Double>();

 public double getPrice(SandwitchType sandwitchType) {
  double result = 0;
  for (Map.Entry<Ingredient, Integer> entry : sandwitchType.getIngredients().entrySet()) {
   Double price = prices.get(entry.getKey());
   if (price == null) {
    throw new IllegalStateException(String.format("Can't calculate price for sandwitch type %s. Reason: "
      + "no price is defined for ingredient %s. Registered ingredient prices: %s",
      sandwitchType, entry.getKey(), prices));
   }
   result += price * entry.getValue();
  }
  return round(result);
 }

 public void setIngredientPrice(Ingredient ingredient, double price) {
  prices.put(ingredient, round(price));
 }

 private static double round(double d) {
  double multiplier = Math.pow(10, PRECISION);
  return Math.floor(d * multiplier + 0.5) / multiplier;
 }
}


package com;

import java.util.Map;
import java.util.EnumMap;

public class Dispenser {

 private final Map<Ingredient, Integer> availableIngredients = new EnumMap<Ingredient, Integer>(Ingredient.class);

 public String buySandwitch(SandwitchType sandwitchType) {
  StringBuilder result = new StringBuilder();
  synchronized (availableIngredients) {

   Map<Ingredient, Integer> buffer = new EnumMap<Ingredient, Integer>(availableIngredients);
   for (Map.Entry<Ingredient, Integer> entry : sandwitchType.getIngredients().entrySet()) {
    Integer currentNumber = buffer.get(entry.getKey());
    if (currentNumber == null || currentNumber < entry.getValue()) {
     result.append(String.format("not enough %s (required %d, available %d), ",
       entry.getKey().getDescription(), entry.getValue(), currentNumber == null ? 0 : currentNumber));
     continue;
    }
    buffer.put(entry.getKey(), currentNumber - entry.getValue());
   }

   if (result.length() <= 0) {
    availableIngredients.clear();
    availableIngredients.putAll(buffer);
    return "";
   }
  }
  if (result.length() > 1) {
   result.setLength(result.length() - 2);
  }
  return result.toString();
 }

 public void load(Ingredient ingredient, int unitsNumber) {
  synchronized (availableIngredients) {
   Integer currentNumber = availableIngredients.get(ingredient);
   if (currentNumber == null) {
    availableIngredients.put(ingredient, unitsNumber);
    return;
   }
   availableIngredients.put(ingredient, currentNumber + unitsNumber);
  }
 }
}


package com;

public class StartClass {
 public static void main(String[] args) {
  Dispenser dispenser = new Dispenser();
  for (Ingredient ingredient : Ingredient.values()) {
   dispenser.load(ingredient, 10);
  }
  PriceList priceList = loadPrices();
  while (true) {
   for (SandwitchType sandwitchType : SandwitchType.values()) {
    System.out.printf("About to buy %s sandwitch. Price is %f...",
      sandwitchType, priceList.getPrice(sandwitchType));
    String rejectReason = dispenser.buySandwitch(sandwitchType);
    if (!rejectReason.isEmpty()) {
     System.out.println(" Failed: " + rejectReason);
     return;
    }
    System.out.println(" Done");
   }
  }
 }

 private static PriceList loadPrices() {
  PriceList priceList = new PriceList();
  double i = 0.1;
  for (Ingredient ingredient : Ingredient.values()) {
   priceList.setIngredientPrice(ingredient, i);
   i *= 2;
  }
  return priceList;
 }
}