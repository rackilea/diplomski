Controller method :
     @GetMapping("/{personalCode}")
        public List<Customer> getCustomersByPersonalCode(@PathVariable String personalCode, @RequestHeader(value="country") String country) {
            return customerService.findByPersonalCodeAndCountry(personalCode, country);
        }

@Results(value = { @Result(column = "id", property = "id"), 
        @Result(column = "cust_personal_code", property = "personalCode"), 
        @Result(column = "cust_bank_country ", property = "country")
    )}
    @Select("Select * FROM customer WHERE cust_personal_code= #{personalCode} AND cust_bank_country = #{country}")
    List<Customer> findByPersonalCodeAndCountry(@Param("personalCode") String personalCode, @Param("country") String country);