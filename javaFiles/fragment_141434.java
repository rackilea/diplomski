beginShape();
              tint(255,127);  
              texture(tex);
              vertex(agents[i].location.x, agents[i].location.y,0.0,0.0);//aditional u,v coordinates 0,0 - top left of texture
              vertex(r1, r2,1.0,0.0);//top right texture coordinate
              vertex(agents[j].location.x, agents[j].location.y,1.0,1.0);//bottom right texture coordinat
              endShape(CLOSE);