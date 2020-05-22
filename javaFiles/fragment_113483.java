Element overrides = request.GetElement("overrides");
Element override1 = overrides.AppendElement();
override1.SetElement("fieldId", "DVD_START_DT");
override1.SetElement("value", "20151101");
Element override2 = overrides.AppendElement();
override2.SetElement("fieldId", "DVD_END_DT");
override2.SetElement("value", "20151231");