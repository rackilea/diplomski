import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;

public class FinderServiceTest {
    // This is created new between each test.
    private ServiceFinder serviceFinder = new ServiceFinder();
/* ***************************************/
/*  PARAMETER TESTS
/* ***************************************/
/*
 * What should happen in these cases? - Is it an Exception? - Should the method return Status.BAD_REQUEST?
 * 
 * org.junit.Assert can be used to compare the response Object with the desired outcome OR
 * org.junit.rules.ExpectedException can be used to verify specific exceptions are thrown
 */
@Test
public void testGetAllLockersNullUserParam() {
    Response response = serviceFinder.getAllLockers(null, "password");

    // Assert the right thing happened.
}

@Test
public void testGetAllLockersEmptyUserParam() {
    Response response = serviceFinder.getAllLockers("", "password");

    // Assert the right thing happened.
}

@Test
public void testGetAllLockersNullPasswordParam() {
    Response response = serviceFinder.getAllLockers("user", null);

    // Assert the right thing happened.
}

@Test
public void testGetAllLockersEmptyPasswordParam() {
    Response response = serviceFinder.getAllLockers("user", "");

    // Assert the right thing happened.
}

/* ***************************************/
/*  BRANCH TESTS (SHORT PATHS)
/* ***************************************/

@Test
public void testGetAllLockersNullValidatedUser() {
    // For ease of use in my case I'm going to pretend that checkLoginValidation 
    // just calls a delegate interface, which I'm calling LoginValidator, with the same API.
    // Which I will mock and set the expected return...
    LoginValidator mockLoginValidator = Mockito.mock(LoginValidator.class);
    Mockito.when(mockLoginValidator.checkLoginValidation()).thenReturn(null);
    //Using PowerMock, I'm going to set the LoginValidator field inside of my service finder.
    //I'm assuming that LoginValidator field in the ServiceFinder is named "loginValidator"
    Whitebox.setInternalState(serviceFinder, "loginValidator", mockLoginValidator);

    //Now that my class is set up to give me the null Validated User, I'll make the call to the test instance
    Response response = serviceFinder.getAllLockers("validUser", "validPassword");

    //From the implementation posted, I know that when the user validates as null I should get back something with a Status.BAD_REQUEST state.
    assertEquals("When the logged in user is null BAD_REQUEST should be returned", Status.BAD_REQUEST, response.getStatus);   
}

@Test
public void testGetAllLockersNullEmployeeList() {
    //FIXME:  Configure user validation to return LoginUser Object.
    //FIXME:  Configure test reference state to return a null employee list when employeeManager.fetchAllEmployees() is called

    Response response = serviceFinder.getAllLockers("validUser", "validPassword");
    assertEquals("When the employee list is null NO_CONTENT should be returned", Status.NO_CONTENT, response.getStatus);   
}

@Test
public void testGetAllLockersEmptyEmployeeList() {
  //FIXME:  Configure user validation to return LoginUser Object.
    //  FIXME:  Configure test reference state to return an empty employee list when employeeManager.fetchAllEmployees() is called

    Response response = serviceFinder.getAllLockers("validUser", "validPassword");
    assertEquals("When the employee list is null NO_CONTENT should be returned", Status.NO_CONTENT, response.getStatus);
}

/* ***************************************/
/*  HAPPY PATH TEST
/* ***************************************/
public void testgetAllLockers() {
  //FIXME:  Configure user validation to return LoginUser Object.
    //  FIXME:  Configure test reference state to return a correctly-populated employee list when employeeManager.fetchAllEmployees() is called

    Response response = serviceFinder.getAllLockers("validUser", "validPassword");
    assertEquals("When the employee list is null NO_CONTENT should be returned", Status.OK, response.getStatus);
    //FIXME get JSON from response reference
    //FIXME Check that JSON holds all of the expected employee list data
}

}