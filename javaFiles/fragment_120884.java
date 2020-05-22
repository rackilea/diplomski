public String addFather(@RequestParam("first_name") String firstName,
                            @RequestParam("birth_date") String birthDate,
                            @RequestParam("second_name") String secondName,
                            @RequestParam("pesel") String pesel) {
        final FatherForm fatherForm = new FatherForm();
        fatherForm.setFirstName(firstName);
        fatherForm.setSecondName(secondName);
        fatherForm.setBirthDate(birthDate);
        fatherForm.setPesel(pesel);
        //...
        return "AddChild";
}