<spring:bind path="nativestring">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:errors path="nativestring"></form:errors>
                <form:input path="nativestring" htmlEscape="false" class="form-control input-lg" placeholder="Translation"></form:input>
            </div>
        </spring:bind>