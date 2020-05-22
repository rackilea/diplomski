if ( concern.callGetLastError() ){
            return _checkWriteError( db , port , concern );
        }
        else {
            return new WriteResult( db , port , concern );
        }