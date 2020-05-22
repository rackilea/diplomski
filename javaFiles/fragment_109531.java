fileInput.add ( new AjaxFormSubmitBehavior(form/*optional*/, 'change') 
                {
                   @Override
                   protected void onSubmit ( AjaxRequestTarget target )
                   {
                      super.onSubmit ( target );
                   }
                   /* you can also override other methods here, 
                      but note that Form's submit method will
                      be called too.*/
                } );