if (!marker.getTitle().equals("Buradasın")) {
                latLngMaps = marker.getPosition();
                share.setVisibility(View.VISIBLE);
                direction.setVisibility(View.VISIBLE);
                bullet.setVisibility(View.VISIBLE);
                access.setVisibility(View.VISIBLE);
            } else {
                bullet.setVisibility(View.VISIBLE);
                share.setVisibility(View.GONE);
                direction.setVisibility(View.GONE);
                access.setVisibility(View.GONE);
            }