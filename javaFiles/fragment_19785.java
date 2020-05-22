<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<c:forEach items="${customers}" var="customer">

<div class="container mt-5"><br>
    <form role="form" action="CustomerController" data-toggle="validator" method="post" id="registerForm">
        <div class="form-group row">
            <label for="name" class="col-sm-2 col-form-label">Name</label>
            <div class="col-sm-10">
              <input type="text" name="name" value="${customer.name}" placeholder="Name">
            </div>
          </div>
          <div class="form-group row">
            <label for="email" class="col-sm-2 col-form-label">Email</label>
            <div class="col-sm-10">
              <input type="email" name="email" value="${customer.email}" placeholder="Email">
            </div>
          </div>
          <div class="form-group row">
            <label for="email" class="col-sm-2 col-form-label">Address</label>
            <div class="col-sm-10">
              <input type="text" name="address" value="${customer.address}" placeholder="Address">
            </div>
          </div>
          <div class="form-group row">
            <label for="sex" class="col-sm-2 col-form-label">Sex</label>
            <div class="col-sm-10">
              <div class="custom-control custom-radio custom-control-inline">
                  <input name="sex" type="radio" value="${customer.sex}" id="customRadioInline1" class="custom-control-input">
                  <label class="custom-control-label" for="customRadioInline1">Male</label>
                </div>
                <div class="custom-control custom-radio custom-control-inline">
                  <input name="sex" type="radio" value="${customer.sex}" id="customRadioInline2" class="custom-control-input">
                  <label class="custom-control-label" for="customRadioInline2">Female</label>
              </div>
            </div>
          </div>
           <div class="form-group row">
            <label for="birthdate" class="col-sm-2 col-form-label">Birthdate</label>
            <div class="col-sm-10">
              <input type="date" name="bday" value="${customer.bday}" placeholder="Birthdate" required>
            </div>
          </div>
          <div class="form-group row">
            <label for="telephone" class="col-sm-2 col-form-label">Telephone</label>
            <div class="col-sm-10">
              <input type="text" name="tele" value="${customer.telephone}" placeholder="Telephone">
            </div>
          </div>
          <div class="form-group row">
            <label for="username" class="col-sm-2 col-form-label">Username</label>
            <div class="col-sm-10">
              <input type="text" name="username" value="${customer.username}" placeholder="Username">
            </div>
          </div>
          <div class="form-group row">
            <label for="passowrd" class="col-sm-2 col-form-label">Password</label>
            <div class="col-sm-10">
              <input type="password" name="password" value="${customer.password}" id="inputPassword" placeholder="Password" data-minlength="6">
              <div class="invalid-feedback">
                Please provide a valid city.
              </div>
            </div>
          </div>
        <button type="submit" class="btn btn-primary btn-block btn-large">Sign me up.</button>
    </form><br>
</div>

</c:forEach>