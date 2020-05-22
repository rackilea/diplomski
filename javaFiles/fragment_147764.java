@TypeDef(
    name = UUIDType.NAME,
    defaultForType = UUID.class,
    typeClass = UUIDType.class
)
package com.xenoterracide.rpf.model;


import org.hibernate.annotations.TypeDef;
import org.hibernate.type.UUIDType;

import java.util.UUID;