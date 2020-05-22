{{#operation}}
    public {{#vendorExtensions.x-async-enabled}}void{{/vendorExtensions.x-async-enabled}}{{^vendorExtensions.x-async-enabled}}Response{{/vendorExtensions.x-async-enabled}} {{nickname}}({{#vendorExtensions.x-async-enabled}}@Suspended final AsyncResponse asyncResponse, {{/vendorExtensions.x-async-enabled}}{{#allParams}}{{>queryParams}}{{>pathParams}}{{>headerParams}}{{>bodyParams}}{{>formParams}},{{/allParams}})
    throws Exception {
        {{#vendorExtensions.x-async-enabled}}
            delegate.{{nickname}}(asyncResponse, {{#allParams}}{{#isFormParam}}{{#isFile}}{{paramName}}InputStream, {{paramName}}Detail{{/isFile}}{{/isFormParam}}{{^isFile}}{{paramName}}{{/isFile}}{{^isFormParam}}{{#isFile}}{{paramName}}{{/isFile}}{{/isFormParam}}, {{/allParams}});
        {{/vendorExtensions.x-async-enabled}}
        {{^vendorExtensions.x-async-enabled}}
            return delegate.{{nickname}}({{#allParams}}{{#isFormParam}}{{#isFile}}{{paramName}}InputStream, {{paramName}}Detail{{/isFile}}{{/isFormParam}}{{^isFile}}{{paramName}}{{/isFile}}{{^isFormParam}}{{#isFile}}{{paramName}}{{/isFile}}{{/isFormParam}}, {{/allParams}});
        {{/vendorExtensions.x-async-enabled}}
    }
{{/operation}}