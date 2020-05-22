// Calculations
usageHoursPerYear     = usageHoursPerDay * usageDaysPerWeek * usageWeeksPerYear; //calculate based on time used, not 365 days in the year
usageWattHoursPerYear = wattsPerHour * usageHoursPerYear; //use variable from above line
usageKWHPerYear       = usageWattHoursPerYear / 1000;
costPerYear           = usageKWHPerYear * COST_PER_KWH;
lbsCO2PerYear         = LBS_CO2_PER_KWH * usageKWHPerYear;

// Printing Energy Audits
System.out.println("Computer Energy Audit");
System.out.println("You use your computer for " + usageHoursPerYear + " hours per year.");
System.out.println("It will use " + usageKWHPerYear + " KWH/year."); //changed to correct variable
System.out.println("Whih will cost " + costPerYear + "$/year for electricity.");
System.out.println("Generating that electricity will produce " + lbsCO2PerYear + " lbs of CO2 pollution.");