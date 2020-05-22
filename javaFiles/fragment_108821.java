/* Note that this is translating further drawing operations
            to the middle of the Hand container based on its preferred size,
            which is (layout manager not withstanding) also its actual size. 
            All co-ordinates in custom painting are relative to the component 
            being painted. */
            g2d.translate(middle, middle);