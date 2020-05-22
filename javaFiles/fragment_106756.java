grid: {
        drawGridLines: true,        // wether to draw lines across the grid or not.
        gridLineColor: '#cccccc'    // *Color of the grid lines.
        background: '#fffdf6',      // CSS color spec for background color of grid.
        borderColor: '#999999',     // CSS color spec for border around grid.
        borderWidth: 2.0,           // pixel width of border around grid.
        shadow: true,               // draw a shadow for grid.
        shadowAngle: 45,            // angle of the shadow.  Clockwise from x axis.
        shadowOffset: 1.5,          // offset from the line of the shadow.
        shadowWidth: 3,             // width of the stroke for the shadow.
        shadowDepth: 3,             // Number of strokes to make when drawing shadow.
                                    // Each stroke offset by shadowOffset from the last.
        shadowAlpha: 0.07           // Opacity of the shadow
        renderer: $.jqplot.CanvasGridRenderer,  // renderer to use to draw the grid.
        rendererOptions: {}         // options to pass to the renderer.  Note, the default
                                    // CanvasGridRenderer takes no additional options.
    },