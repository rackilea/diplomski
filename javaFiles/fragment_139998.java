<form id="confirmationForm" name="confirmationForm" action="/auth/oauth/authorize" method="post">
    <!-- 
    The ApprovalStoreUserApprovalHandler tests scopes by testing request-params prefixed with `scope.*` 
    For dynamic input-element rendering one might iterate over
    ${authorizationRequest.scope}

    Provides access to the scope=openid whenever the user checks the checkbox:
    -->
    <input name="scope.openid" value="true" type="checkbox" /> OpenID<br>
    <input type="hidden"  name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button class="btn btn-primary" type="submit">Approve</button>
</form>