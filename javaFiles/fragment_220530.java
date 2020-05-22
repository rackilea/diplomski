Element overridesElt = request.getElement("overrides");
Element override = overridesElt.appendElement();
override.setElement("fieldId", "VWAP_START_TIME");
override.setElement("value", "09:00:00");

override = overridesElt.appendElement();
override.setElement("fieldId", "VWAP_END_TIME");
override.setElement("value", "11:00:00");