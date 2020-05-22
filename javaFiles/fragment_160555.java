<script>
        $(document).ready(function() {
            $('#registerForm').submit(function(event) {
            event.preventDefault();
                var formData = $('#registerForm').serialize();    /* capture the form data*/
                $.getJSON('/admin/user/signup', formData, registerResults);
           //     $.post('/admin/user/signup', formData, registerResults);   /* get JSON back from the post method */
            });
            function registerResults(data) {
                    $('#registerForm').fadeOut();
                    $('.starter-template').html(data.message);
                }  // end of registerResults
        });  // end of ready
        </script>