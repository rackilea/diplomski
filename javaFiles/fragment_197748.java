xId='$Id'; xDate='$Date'; xRev='$Rev'; xAuthor='$Author'
cat <<EOT >> "$FILENAME_IMPL"
/*
 * *********************************************************************
 *  Revision Control Information
 *  File:                $xId::                                         $
 *  Date of Last Commit: $xDate::                                       $
 *  Revision Number:     $xRev::                                        $
 *  Last Commit by:      $xAuthor::                                     $
 *
 * **********************************************************************
 */
package com.company.pkg;
EOT