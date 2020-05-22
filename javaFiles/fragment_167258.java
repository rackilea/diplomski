@org.hibernate.annotations.NamedQueries({
    @org.hibernate.annotations.NamedQuery(
        name = "foo.findAllUsers", 
        query="from Users") 
}) 

package com.foo.domain;