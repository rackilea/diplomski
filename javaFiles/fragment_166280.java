String explosion_type = this.prefs.getString("explosion_type", "ring_explosion");
    Log.i("imagename", explosion_type);
    BitmapFactory.Options optionsExplosion = new BitmapFactory.Options();
    optionsExplosion.inPurgeable = true;

     int imageResource = getResources().getIdentifier(explosion_type, "drawable", getPackageName());

        this._explosionSprite = BitmapFactory.decodeResource(_context.getResources(), imageResource, optionsExplosion);