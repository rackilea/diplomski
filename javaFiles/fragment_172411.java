try {
            createSeller(...);
        } catch(org.springframework.orm.jpa.JpaSystemException e){
            if (e.contains(org.hibernate.exception.ConstraintViolationException.class)){
                return thisMethodThatCallsCreateSeller(...);
            } else {
                throw e;
            }
        }