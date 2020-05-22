<?php wp_footer(); ?>
<script>
var container = document.querySelector('#blog-list-center');
var $pckry;
var $pckry = new Packery( container, {
// options
itemSelector: '.item',
gutter: 0,
});
// initialize Packery after all images have loaded
imagesLoaded( container, function() {
$pckry = new Packery( container );
});
</script>
</body>

</html>