jQuery(document).ready(function() {

    $('.deleteBtn').on('click', function() {
        var selectValue = $('.search').find('select').val()
        window.location.replace("/result/name/" + selectValue);
    })

})