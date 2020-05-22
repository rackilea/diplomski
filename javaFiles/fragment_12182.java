@Test
public void hiringWorksAsItShould() throws Exception {
    // CLASS UNDER TEST   \/
    GroupManager gm = new GroupManager("John Doe", "manager", 1);

    // Mock "developer"...
    Developer developer = mock(Developer.class);

    gm.hire(developer); 

    verify(developer).setSupervisor(gm);        
}