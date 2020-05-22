@TypeDef(
    name = UUIDCustomType.UUID,
    defaultForType = UUID.class,
    typeClass = UUIDCustomType.class
)
package com.xenoterracide.rpf.model;

import org.hibernate.annotations.TypeDef;
import org.hibernate.type.UUIDCustomType;

import java.util.UUID;