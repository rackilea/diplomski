// Updating particle object before 
// checking for time lapse
p.update();

// Append outdated particles to removeParticles
// if time limit has passed
if(System.nanoTime() - p.timePassed >= Config.particleLife) {
    removeParticles.add(p);
}