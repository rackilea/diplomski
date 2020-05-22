protected AjaxEventBehavior newAjaxEventBehavior(String event)
{
    return new AjaxEventBehavior(event)
    {
        private static final long serialVersionUID = 1L;

        @Override
        protected void onEvent(AjaxRequestTarget target)
        {
            onClick(target);
        }

        @Override
        protected void updateAjaxAttributes(AjaxRequestAttributes attributes)
        {
            super.updateAjaxAttributes(attributes);
            AjaxLink.this.updateAjaxAttributes(attributes);
        }
    };
}