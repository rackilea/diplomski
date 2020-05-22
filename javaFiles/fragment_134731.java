if (MusicUtils.isOnline(mContext)) {
            mArtistResults = Artist.getImages("Andrew Bird", 1, 1, key);
            mArtistIterator = mArtistResults.getPageResults().iterator();
            while (mArtistIterator.hasNext()) {
                mArtistImageURL = mArtistIterator.next().getImageURL(
                        ImageSize.ORIGINAL);
            if(mArtistImageURL!=null)
             setUrlForArtist("Andrew Bird", mArtistImageURL);
            }
        } else
              mArtistImageURL = getUrlForArtist("Andrew Bird");