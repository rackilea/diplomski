jQuery(document).ready(function(){
    jQuery('.tabs .tab-links a').on('click', function(e){
     var currentAttrValue = jQuery(this).attr('href');

        $('.tabs ' + currentAttrValue).show();
      $('.tabs ' + currentAttrValue).animate({opacity:1, paddingLeft:'30%'}, 400); 
      $('.tabs ' + currentAttrValue).siblings().css({opacity:0, paddingLeft:'0%'}).hide(); 
      
        jQuery(this).parent('li').addClass('active').siblings().removeClass('active');
      
     e.preventDefault();
    });
});