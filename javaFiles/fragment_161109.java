@RequestMapping(value="/save")
    public String showList(@ModelAttribute DynamicRowForm dynamicRowForm) {
        System.out.println(dynamicRowForm.getDynamicRow().get(0).getId());
        System.out.println(dynamicRowForm.getDynamicRow().get(0).getName());
        System.out.println(dynamicRowForm.getDynamicRow().get(0).getEmail());
        return "success";
    }