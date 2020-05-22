package com.a.b

@Configuration
@Import ({Entity1.class, Entity1Repo.class, Entity1Key.class, 
  Entity2.class, ... })
class EntityConfig {}