migLayout(layoutConstraints: 'fill, wrap 2', 
    columnConstraints: '[grow|]', 
    rowConstraints: '[grow|]')

panel (constraints: 'spany 2, grow') { 
    // Main content with the picture go in here 
}
list(constraints: 'grow') { 
    // Top list 
}
list(constraints: 'grow') { 
    // Bottom list 
}

panel(constraints: 'grow') { 
    // Bottom panel 
}
panel() { 
    // Button panel 
}