public void updateQuote(long qu_id, int qu_like, int qu_share) {
            open();
            ContentValues v = new ContentValues();
            v.put(QU_LIKE, qu_like);
            v.put(QU_SHARE, qu_share);

            database.update(TABLE_QUOTES, v, "qu_id=" + qu_id, null);

        }