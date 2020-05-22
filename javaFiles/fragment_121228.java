this.add( this.interactionbehavior = new AbstractDefaultAjaxBehavior()
    {

        @Override
        protected void respond( final AjaxRequestTarget target )
        {
            RequestCycle cycle = RequestCycle.get();
            WebRequest webRequest = (WebRequest) cycle.getRequest();
            String param1 = webRequest.getQueryParameters().getParameterValue( "mydict" ).toString( "" );
            //param1 contains the JSON map passed from javascript.
            //you can also do stuff now, like replacing components using ajax
        }

        @Override
        protected void updateAjaxAttributes( AjaxRequestAttributes attributes )
        {
            super.updateAjaxAttributes( attributes );
            attributes.getExtraParameters().put( "mydict", "__PLACEHOLDER__" );
        }

        @Override
        public CharSequence getCallbackScript()
        {
            String script = super.getCallbackScript().toString().replace( "\"__PLACEHOLDER__\"", "data" );
            return script;
        }
    } );