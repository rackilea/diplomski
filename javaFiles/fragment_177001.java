package com.acme;

@Singleton(name="Shared")
@LocalBean
@Remote(com.acme.SharedRemote.class)
public class SharedBean { ... }