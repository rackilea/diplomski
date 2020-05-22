Period membershipLength = Period.ofYears(1);
LocalDate membershipStart = ...;
LocalDate membershipEnd = membershipStart.plus(membershipLength);

LocalDate today = LocalDate.now();
boolean memberShipEnded = today.isAfter(membershipEnd);
boolean membershipValid = !membershipEnded;