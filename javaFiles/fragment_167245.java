public static native void cytoscape() /*-{
           var obj = new $wnd.Object();
           obj.container = $wnd.document.getElementById('cy');//can also be simply $doc.getElementById('cy')
           obj.elements = $wnd.glyElements;
           // Note that you may have to repeat this for each of these nested objects, depending
           // on how picky the library is being on otherwise identically structured code...
           obj.style = [ { selector: 'node', style: { 'background-color': '#666', 'label': 'data(id)' } }, 
                   { selector: 'edge', style: { 'width': 3, 'line-color': '#ccc', 'target-arrow-color': '#ccc',
   'target-arrow-shape': 'triangle' } } ];
           obj.layout = { name: 'grid', rows: 1 };
           var cy = $wnd.cy = $wnd.cytoscape(obj);
       }-*/;