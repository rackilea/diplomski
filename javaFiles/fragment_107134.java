public static void calcuateInterval(Card card) {
  if (card.getEFactor() < 3) {
      card.setCount(1);
  }
  int count = card.getCount();
  int interval = 1;
  if (count == 2) {
      interval = 6;
  } else if (count > 2) {
     interval =  Math.round(card.getInterval() * card.getEFactor());
  }
  card.setInterval(interval);
}