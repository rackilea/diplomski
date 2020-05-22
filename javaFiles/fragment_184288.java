<script>
    var imgs = document.getElementsByTagName('img');
    for(var i = 0; i &lt; imgs.length; i++) {
        var iconFound = imgs[i].parentNode.getAttribute('class').indexOf('rich-tree-node-icon') >= 0;
        var imgSrc = imgs[i].getAttribute('src');
        if(iconFound &amp;&amp; (imgSrc == '')) {
            imgs[i].style.display = 'none';
        }
    }
</script>