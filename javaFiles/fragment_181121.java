package com.example.stackoverflow;

import javax.persistence.NoResultException;

aspect NullifyNoResultException {
    Object around() : execution(public Object com.example..*(..)) {
        try {
            return proceed();
        } catch (NoResultException e) {
            return null;
        }
    }
}