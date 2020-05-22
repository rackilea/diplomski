@Override
  public List<RealTimeData> loadAll() {
    /// PREPARE THE QUERY, SQL, AND CURSOR.
    final String _sql = "SELECT * FROM realtime_data";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      // OBTAIN THE COLUMN NAMES FROM THE TABLE DEFINITION
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfJsonData = _cursor.getColumnIndexOrThrow("json_data");
      final int _cursorIndexOfIsSent = _cursor.getColumnIndexOrThrow("is_sent");
      final int _cursorIndexOfDeviceId = _cursor.getColumnIndexOrThrow("device_id");
      final int _cursorIndexOfDateCreated = _cursor.getColumnIndexOrThrow("date_created");

      // THIS WILL STORE THE RESULTS
      final List<RealTimeData> _result = new ArrayList<RealTimeData>(_cursor.getCount());

      // ITERATE IT, CREATE A "RealTimeData" AND POPULATE IT.
      while(_cursor.moveToNext()) {
        final RealTimeData _item;
        final String _tmpId;
        _tmpId = _cursor.getString(_cursorIndexOfId);
        final String _tmpJsonData;
        _tmpJsonData = _cursor.getString(_cursorIndexOfJsonData);
        final Date _tmpDateCreated;
        final Long _tmp;
        // SOME THINGS NEED EXTRA CHECKS, THIS IS A DATE FIELD, STORED AS "long", SO NULL MUST BE CHECKED OR THE DATE CONVERTER WOULD THROW NPE
        if (_cursor.isNull(_cursorIndexOfDateCreated)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfDateCreated);
        }
        // IT'S A DATE, SO CALL THE DATE CONVERTER (supplied via the @TypeConverter() annotation)
        _tmpDateCreated = DateConverter.toDate(_tmp);


        // BAM: INVOKE THE CTOR
        _item = new RealTimeData(_tmpId,_tmpJsonData,_tmpDateCreated);

        // NOW USE SETTERS FOR THE "OTHERS" 
        final boolean _tmpIsSent;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsSent);
        _tmpIsSent = _tmp_1 != 0;
        _item.setSent(_tmpIsSent);
        final String _tmpDeviceId;
        _tmpDeviceId = _cursor.getString(_cursorIndexOfDeviceId);
        _item.setDeviceId(_tmpDeviceId);

         // AND ADD IT TO THE RESULTS...
        _result.add(_item);
      }

      // YOU GET THIS ONE :p
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }