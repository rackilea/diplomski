mockMvc.perform(get("/company/5").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andDo(document("company",
                responseFields(
                        fieldWithPath("companyName").description(
                                "The name of the company"),
                        fieldWithPath("employee").description(
                                "An array of the company's employees"))))
        .andDo(document("employee",
                responseFields(
                        fieldWithPath("companyName").ignored(),
                        fieldWithPath("employee[].name").description(
                                "The name of the employee"),
                        fieldWithPath("employee[].age").description(
                                "The age of the employee"))));