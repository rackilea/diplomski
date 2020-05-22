// you specified both Java AND JavaScript; I've picked JavaScript

var originalLine1 = "...",
    originalLine2 = "...";

// somehow call USPS validation to set the following:
var validatedLine1 = "...",
    validatedLine2 = "...",
    validationPassed = true || false;

// now, did validation pass?
if (validationPassed) {
  // if we can match the old line 1 with the left-hand side
  // of the new line 1, and we're not going to be overwriting
  // a non-null value in the new line 2 then split the new line 1
  if (validatedLine2 === null &&
      originalLine1.toLowerCase()
        === validatedLine1.substr(0,originalLine1.length).toLowerCase()) {

    validatedLine2 = validatedLine1.substr(originalLine1.length);
    validatedLine1 = validatedLine1.substr(0, originalLine1.length);
  }
  // do something with the results
}