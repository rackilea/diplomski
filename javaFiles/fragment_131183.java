//set the sign's text
sign.setLine(0, "[FastTravel]");
sign.setLine(1, name + " 1");
sign.setLine(3, (String) getConfig().get("FastTravel.Price"));

//update the sign
sign.update(true);