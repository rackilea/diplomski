const lights = [false, false, false];

//toggling flags except the first one
for (let k = 1; k < lights.length; k++)
    lights[k] = !lights[k];
    
console.log(lights);