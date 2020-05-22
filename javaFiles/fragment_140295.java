String field = "CALENDAR_HOLIDAYS";
//String field = "CALENDAR_NON_SETTLEMENT_DATES";
Request request = this._refDataServiceM.CreateRequest("ReferenceDataRequest");
Element securities = request.GetElement("securities");
securities.AppendValue("AAPL US Equity");
Element fields = request.GetElement("fields");
fields.AppendValue(field);

Element overridefields = request.GetElement("overrides");
Element overrides = request.GetElement("overrides");
Element override1 = overrides.AppendElement();
override1.SetElement("fieldId", "SETTLEMENT_CALENDAR_CODE");
override1.SetElement("value", calendar_code);
Element override2 = overrides.AppendElement();
override2.SetElement("fieldId", "CALENDAR_START_DATE");
override2.SetElement("value", startDate.ToString("yyyyMMdd"));
Element override3 = overrides.AppendElement();
override3.SetElement("fieldId", "CALENDAR_END_DATE");
override3.SetElement("value", endDate.ToString("yyyyMMdd"));