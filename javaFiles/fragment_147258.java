@PostMapping(value = "/contactsSearch")
    fun searchForContacts(@RequestParam(value = "typeOfSearch") typeOfSearch: String,
                          @RequestParam(value = "searchParam") searchParam: String, model: Model): String {
        val contacts = contactService.retrieveContactsBySearch(typeOfSearch, searchParam)
        model.addAttribute(CONTACT_LIST, contacts)
        model.addAttribute(SELECTOR, typeOfSearch)
        model.addAttribute(SEARCH_PARAM, searchParam)
        model.addAttribute(SELECTION, SELECTION_PARAMS)

        return CONTACTS_SEARCH
    }