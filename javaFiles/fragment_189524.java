IList<CountryDto> originalCountries = Service.GetCountries();
IList<CountryDto> validatedCountries = ApplyDefaults(originalCountries);
validatedCountries.Add(mySpecialCountry);

OutputOriginalCountries(originalCountries);
OutputValidatedCountries(validatedCountries);