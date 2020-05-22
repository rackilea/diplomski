%{
#include "session.h"
%}
%extend session {
    const media& getMedia(int i) {
        return media[i];
    }
}