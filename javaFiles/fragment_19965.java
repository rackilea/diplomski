@RequestMapping(value = "/users/update")
    public String update(ModelMap model, @ModelAttribute("record") KCSUser record) {

        if (record.getId() == 0) {
            service.insert(record);
        }
        else {
            KCSUser existing = service.find(record.getId());
            existing.setUserName(record.getUserName());
            existing.setEmail(record.getEmail());
            //etc...
            service.update(existing);
        }

        return index(model);
    }