-----------------------------------com.example.Burger.java-----------------------------------

package com.example;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"burgerTypes"
})
public class Burger {

@JsonProperty("burgerTypes")
public List<BurgerType> burgerTypes = null;

}
-----------------------------------com.example.BurgerSauce.java-----------------------------------

package com.example;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"Name"
})
public class BurgerSauce {

@JsonProperty("Name")
public String name;

}
-----------------------------------com.example.BurgerTopping.java-----------------------------------

package com.example;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"Name"
})
public class BurgerTopping {

@JsonProperty("Name")
public String name;

}
-----------------------------------com.example.BurgerType.java-----------------------------------

package com.example;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"Name",
"Price"
})
public class BurgerType {

@JsonProperty("Name")
public String name;
@JsonProperty("Price")
public Float price;

}
-----------------------------------com.example.Example.java-----------------------------------

package com.example;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"burger",
"burgerToppings",
"burgerSauces"
})
public class Example {

@JsonProperty("burger")
public Burger burger;
@JsonProperty("burgerToppings")
public List<BurgerTopping> burgerToppings = null;
@JsonProperty("burgerSauces")
public List<BurgerSauce> burgerSauces = null;

}