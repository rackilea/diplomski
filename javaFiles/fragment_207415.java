for(i=-radius;i<=radius;i++){
            int ind = yi+Math.min(wm,Math.max(i,0));
            p=pix[ind];
            rsum+=(p & 0xff0000)>>16;
            gsum+=(p & 0x00ff00)>>8;
            bsum+= p & 0x0000ff;
        }