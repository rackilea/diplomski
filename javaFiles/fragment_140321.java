public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) 
    {
          .......

          if(!Validation.isValidEmailAddress(getEmailid()))
                  {
              errors.add("emailid", new ActionError("prompt.email.error"));
                  }
          if(!Validation.isPhoneNumberValid(getMobile()))
          {
              errors.add("mobile", new ActionError("prompt.contactno.error"));
          }

          if(!Validation.isNumeric(getPrice()))
          {
              errors.add("price", new ActionError("prompt.price.error"));
          }


        return errors;
    }